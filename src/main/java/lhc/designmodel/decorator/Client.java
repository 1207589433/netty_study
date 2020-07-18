package lhc.designmodel.decorator;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/18 00:08
 */
public class Client {
    public static void main(String[] args) {

        Component component=new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent()));
        component.doSomething();
    }
}
