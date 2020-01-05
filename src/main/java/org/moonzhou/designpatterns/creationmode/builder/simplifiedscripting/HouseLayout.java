package org.moonzhou.designpatterns.creationmode.builder.simplifiedscripting;

/**
 * @Description 房屋户型
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/5
 */
public enum HouseLayout {

    ONE_BEDROOM("单室"),
    TWO_BEDROOM("两室"),
    THREE_BEDROOM("三室"),
    VILLA("别墅"),
    ;

    private final String title;

    HouseLayout(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "HouseLayout{" +
                "title='" + title + '\'' +
                '}';
    }
}
