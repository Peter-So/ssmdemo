/**   
* @Title: MappingJackson27HttpMessageConverter.java 
* @Package com.mabang.tuanche.admin.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author PeterSo  supei_slm@qq.com
* @date 2016年4月8日 下午6:20:02 
* @version V1.0   
*/
package com.peter.ssmdemo.util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.core.ResolvableType;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.util.TypeUtils;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.type.TypeFactory;

/** 
* @ClassName: MappingJackson27HttpMessageConverter 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author PeterSo  supei_slm@qq.com
* @date 2016年4月8日 下午6:20:02 
*/
public class MappingJackson27HttpMessageConverter extends MappingJackson2HttpMessageConverter {

	 public MappingJackson27HttpMessageConverter() {
	    }

	    public MappingJackson27HttpMessageConverter(ObjectMapper objectMapper) {
	        super(objectMapper);
	    }

	    @Override
	    public boolean canRead(Type type, Class<?> contextClass, MediaType mediaType) {
	        JavaType javaType = getJavaType(type, contextClass);
	        if (!logger.isWarnEnabled()) {
	            return (this.objectMapper.canDeserialize(javaType) && canRead(mediaType));
	        }
	        AtomicReference<Throwable> causeRef = new AtomicReference<Throwable>();
	        if (this.objectMapper.canDeserialize(javaType, causeRef) && canRead(mediaType)) {
	            return true;
	        }
	        Throwable cause = causeRef.get();
	        if (cause != null) {
	            String msg = "Failed to evaluate deserialization for type " + javaType;
	            if (logger.isDebugEnabled()) {
	                logger.warn(msg, cause);
	            } else {
	                logger.warn(msg + ": " + cause);
	            }
	        }
	        return false;
	    }

	    @Override
	    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
	        if (!logger.isWarnEnabled()) {
	            return (this.objectMapper.canSerialize(clazz) && canWrite(mediaType));
	        }
	        AtomicReference<Throwable> causeRef = new AtomicReference<Throwable>();
	        if (this.objectMapper.canSerialize(clazz, causeRef) && canWrite(mediaType)) {
	            return true;
	        }
	        Throwable cause = causeRef.get();
	        if (cause != null) {
	            String msg = "Failed to evaluate serialization for type [" + clazz + "]";
	            if (logger.isDebugEnabled()) {
	                logger.warn(msg, cause);
	            } else {
	                logger.warn(msg + ": " + cause);
	            }
	        }
	        return false;
	    }

	    @Override
	    protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage)
	        throws IOException, HttpMessageNotWritableException {

	        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
	        JsonGenerator generator = this.objectMapper.getFactory().createGenerator(outputMessage.getBody(), encoding);
	        try {
	            writePrefix(generator, object);

	            Class<?> serializationView = null;
	            FilterProvider filters = null;
	            Object value = object;
	            JavaType javaType = null;
	            if (object instanceof MappingJacksonValue) {
	                MappingJacksonValue container = (MappingJacksonValue) object;
	                value = container.getValue();
	                serializationView = container.getSerializationView();
	                filters = container.getFilters();
	            }
	            if (type != null && value != null && TypeUtils.isAssignable(type, value.getClass())) {
	                javaType = getJavaType(type, null);
	            }
	            ObjectWriter objectWriter;
	            if (serializationView != null) {
	                objectWriter = this.objectMapper.writerWithView(serializationView);
	            } else if (filters != null) {
	                objectWriter = this.objectMapper.writer(filters);
	            } else {
	                objectWriter = this.objectMapper.writer();
	            }
	            if (javaType != null && javaType.isContainerType()) {
	                objectWriter = objectWriter.forType(javaType);
	            }
	            objectWriter.writeValue(generator, value);

	            writeSuffix(generator, object);
	            generator.flush();

	        } catch (JsonProcessingException ex) {
	            throw new HttpMessageNotWritableException("Could not write content: " + ex.getMessage(), ex);
	        }
	    }

	    /**
	     * Return the Jackson {@link JavaType} for the specified type and context
	     * class.
	     * <p>
	     * The default implementation returns
	     * {@code typeFactory.constructType(type, contextClass)}, but this can be
	     * overridden in subclasses, to allow for custom generic collection
	     * handling. For instance:
	     * <pre class="code">
	     * protected JavaType getJavaType(Type type) { if (type instanceof Class &&
	     * List.class.isAssignableFrom((Class)type)) { return
	     * TypeFactory.collectionType(ArrayList.class, MyBean.class); } else {
	     * return super.getJavaType(type); } }
	     * </pre>
	     *
	     * @param type the generic type to return the Jackson JavaType for
	     * @param contextClass a context class for the target type, for example a
	     * class in which the target type appears in a method signature (can be
	     * {@code null})
	     * @return the Jackson JavaType
	     */
	    @Override
	    protected JavaType getJavaType(Type type, Class<?> contextClass) {
	        TypeFactory typeFactory = this.objectMapper.getTypeFactory();
	        if (type instanceof TypeVariable && contextClass != null) {
	            ResolvableType resolvedType = resolveVariable(
	                (TypeVariable<?>) type, ResolvableType.forClass(contextClass));
	            if (resolvedType != ResolvableType.NONE) {
	                return typeFactory.constructType(resolvedType.resolve());
	            }
	        }
	        return typeFactory.constructType(type);
	    }

	    private ResolvableType resolveVariable(TypeVariable<?> typeVariable, ResolvableType contextType) {
	        ResolvableType resolvedType;
	        if (contextType.hasGenerics()) {
	            resolvedType = ResolvableType.forType(typeVariable, contextType);
	            if (resolvedType.resolve() != null) {
	                return resolvedType;
	            }
	        }
	        resolvedType = resolveVariable(typeVariable, contextType.getSuperType());
	        if (resolvedType.resolve() != null) {
	            return resolvedType;
	        }
	        for (ResolvableType ifc : contextType.getInterfaces()) {
	            resolvedType = resolveVariable(typeVariable, ifc);
	            if (resolvedType.resolve() != null) {
	                return resolvedType;
	            }
	        }
	        return ResolvableType.NONE;
	    }

}
