package lhc.designmodel.decorator;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/18 00:07
 */
public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }
    @Override
    public void doSomething() {
        super.doSomething();
        this.doAnotherThing();
    }
    private void doAnotherThing(){
        System.out.println("功能C");
    }
}
