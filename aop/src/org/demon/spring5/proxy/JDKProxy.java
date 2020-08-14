package org.demon.spring5.proxy;

import org.demon.spring5.dao.UserDao;
import org.demon.spring5.dao.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {

    public static void main(String[] args){
        Class[] interfaces = { UserDao.class };
        UserDaoImpl user = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(user));
        dao.add(7,7);
    }

}
class UserDaoProxy implements InvocationHandler{

    // 接收被代理类
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    // invoke 方法就是在被代理类的方法被调用时，真正被调用的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 目标方法之前
        System.out.println(method.getName() + " 执行之前 ..." + " 传递的参数是 " + Arrays.toString(args));
        // 调用目标方法
        Object res = method.invoke(obj, args);
        // 目标方法之后
        System.out.println(method.getName() + " 执行之后 ..." + " 结果是 " + res);

        return res;
    }
}
