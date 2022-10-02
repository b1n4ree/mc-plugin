package com.simplug.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

public class MyComponents {

    public Component hpBar(Double currentHp, Double damagedHp) {

        return Component.text("HP ").color(TextColor.color(69, 255, 1))
                .append(Component.text("" + currentHp).color(TextColor.color(255, 0, 13)))
                .append(Component.text(" / "))
                .append(Component.text("" + (currentHp - damagedHp)).color(TextColor.color(255, 96, 84)));
    }
}
