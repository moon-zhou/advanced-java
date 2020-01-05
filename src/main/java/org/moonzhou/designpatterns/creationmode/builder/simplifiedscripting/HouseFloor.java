package org.moonzhou.designpatterns.creationmode.builder.simplifiedscripting;

/**
 * @Description 房屋楼层
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/5
 */
public enum HouseFloor {

    LOW_RISE("低层", "1~6层"),
    MIDDLE_RISE("中层", "7~9层"),
    HIGH_RISE("高层", "10层以上"),
    ;

    private final String title;

    private final String description;

    HouseFloor(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "HouseFloor{" +
                "title='" + title + '\'' +
                '}';
    }
}
