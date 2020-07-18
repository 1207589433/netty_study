package lhc.designmodel.decorator;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/18 00:01
 */
//装饰角色
public class Decorator implements Component {
    //持有抽象构建角色的引用
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    //并定义一个与抽象构建接口一致的接口
    @Override
    public void doSomething() {
        component.doSomething();
    }
}
