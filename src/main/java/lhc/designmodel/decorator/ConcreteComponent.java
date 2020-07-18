package lhc.designmodel.decorator;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/18 00:00
 */
//具体构建角色
public class ConcreteComponent implements Component {
    @Override
    public void doSomething() {
        System.out.println("功能A");
    }
}
