package lhc.designmodel.decorator;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/18 00:05
 */
//具体装饰角色：负责给构建对象贴上附加的责任。
public class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        this.doAnotherThing();
    }
    private void doAnotherThing(){
        System.out.println("功能B");
    }
}
