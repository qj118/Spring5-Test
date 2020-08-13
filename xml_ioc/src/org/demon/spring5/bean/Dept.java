package org.demon.spring5.bean;

public class Dept {

    private String dName;

    public Dept(){
        System.out.println("Dept - 无参构造创建 bean 实例");
    }

    public void initMethod(){
        System.out.println("Dept - 初始化方法");
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
        System.out.println("Dept - set方法设置属性值");
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dName='" + dName + '\'' +
                '}';
    }

    public void destroyMethod(){
        System.out.println("Dept - 销毁方法");
    }
}
