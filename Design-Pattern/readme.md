##设计模式常用的七大原则有：
- 单一职责原则：对类来说，一个类应该只负责一项原则。
- 接口隔离原则:客户端不应该依赖它不需要的接口，即一个类对另一个类的依赖应该建立在最小的接口上。
- 依赖倒转原则：高层模块不应该依赖底层模块，二者都应该依赖抽象；抽象不应该依赖细节，细节应该依赖抽象；依赖倒转的中心思想是面向接口编程。
- 里氏替换原则：任何基类可以出现的地方，子类一定可以出现。
- 开闭原则
- 迪米特法则
- 合成复用原则

### 单一职责原则注意事项和细节
- 降低类的复杂度，一个类只负责一项职责。
- 提高类的可读性和可维护性。
- 降低变更引起得的风险
- 通常情况下，我们应当遵守单一职责原则，只有逻辑足够简单，才可以在代码 级别违反单一职责原则；只有类中的方法足够少，可以在方法级别保持单一职责原则。
### 依赖倒转原则的注意事项和细节
- 底层模块尽量都要有抽象类和接口，或者两者都有，程序稳定性好
- 变量的声明类型尽量是抽象类或接口，这样我们的变量引用和实际对象间，就存在一个缓冲层，利于程序扩展和优化。
- 继承时尊徐里氏替换原则。


