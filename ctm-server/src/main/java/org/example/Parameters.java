package org.example;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

//@EqualsAndHashCode(callSuper = true)
//@NoArgsConstructor
//@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parameters extends HashMap<Object, Object> {
    private static final long serialVersionUID = 1;
    private boolean ok = true;
    private boolean unsupported = false;
    private String msg = "";

    public Parameters() {
    }

    public Parameters(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public Parameters(int initialCapacity) {
        super(initialCapacity);
    }

    public Parameters(Map<? extends Object, ? extends Object> m) {
        super(m);
    }

    public Parameters(Object... args) {
        if ((args == null) || (args.length < 2)) return;

        for (int i = 0; i < (args.length); i = i + 2) {
            put(args[i], args[i + 1]);
        }
    }

    public Parameters set(Object... args) {
        clear();
        if ((args == null) || (args.length < 2)) return this;
        for (int i = 0; i < (args.length / 2); i++) {
            put(args[i * 2], args[i * 2 + 1]);
        }
        return this;
    }

    public Parameters setError(boolean isOk, String message) {
        setOk(isOk);
        setMsg(message);
        return this;
    }


    public Parameters setBean(Object bean) {
        clear();
        Class<?> beanClass = bean.getClass();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            if (propertyDescriptors != null) {
                for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    if (propertyDescriptor != null) {
                        String name = propertyDescriptor.getName();
                        Method readMethod = propertyDescriptor.getReadMethod();
                        if (readMethod.getDeclaringClass() == Object.class) continue;
                        if (readMethod != null) {
                            Object value = readMethod.invoke(bean);
                            if (value instanceof Serializable) put(name, value);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }


//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        for (Object k : keySet()) {
//
//            Object value = get(k);
//            sb.append('{');
//            sb.append(k);
//            sb.append('=');
//            sb.append(value);
//            sb.append(" ");
//            sb.append('}');
//        }
//        return sb.toString();
//    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object k : keySet()) {

            Object value = get(k);
            sb.append('{');
            sb.append(k);
            sb.append('=');
            sb.append(value);
            sb.append(" ");
            sb.append('}');
        }
        return "Parameters{" +
                "ok=" + ok +
                ", unsupported=" + unsupported +
                ", msg='" + msg + '\'' +
                '}' +
                sb.toString();
    }

    public Parameters setUnsupported() {
        unsupported = true;
        return this;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public boolean isUnsupported() {
        return unsupported;
    }

    public void setUnsupported(boolean unsupported) {
        this.unsupported = unsupported;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}