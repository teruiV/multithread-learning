package chapter2.immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 不可变类的条件：1. 属性均为final类型 2. 属性访问权限为private 3. 不可变，无setter方法 4. 如果属性为引用，需要做一次深拷贝。
 * @author jianweilin
 * @date 2018/9/1
 */

@Getter
@AllArgsConstructor
public final class Person {
    private final String name;
    private final String address;
}
