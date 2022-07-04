package org.moonzhou.dailyprogramming;

import java.time.Duration;

/**
 * @author moonzhou
 */
public class TestDuration {
    public static void main(String[] args) {
        Duration duration = Duration.ofDays(1L);
        System.out.println(duration);
        System.out.println(duration.getSeconds());
    }
}
