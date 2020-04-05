package org.moonzhou.designpatterns.creationmode.builder.simplifiedscripting;

/**
 * @Description
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/5
 */
public class MyHouse {
    private final HouseArea houseArea;
    private final HouseLayout houseLayout;
    private final HouseFloor houseFloor;
    private final String name;

    private MyHouse(Builder builder) {
        this.houseArea = builder.houseArea;
        this.houseLayout = builder.houseLayout;
        this.houseFloor = builder.houseFloor;
        this.name = builder.name;
    }

    public HouseArea getHouseArea() {
        return houseArea;
    }

    public HouseLayout getHouseLayout() {
        return houseLayout;
    }

    public HouseFloor getHouseFloor() {
        return houseFloor;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MyHouse{" +
                "houseArea=" + houseArea +
                ", houseLayout=" + houseLayout +
                ", houseFloor=" + houseFloor +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 具体建造者类
     */
    public static class Builder {
        private final String name;
        private final HouseArea houseArea;
        private HouseLayout houseLayout;
        private HouseFloor houseFloor;

        public Builder(String name, HouseArea houseArea) {
            if (null == name || null == houseArea) {
                throw new IllegalArgumentException("name and houseArea can not be null");
            }

            this.name = name;
            this.houseArea = houseArea;
        }

        public Builder withHouseLayout(HouseLayout houseLayout) {
            this.houseLayout = houseLayout;

            return this;
        }

        public Builder withHouseFloor(HouseFloor houseFloor) {
            this.houseFloor = houseFloor;

            return this;
        }

        public MyHouse build() {
            return new MyHouse(this);
        }
    }

}
