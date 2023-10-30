package annotation.app;

import annotation.Fancy;

@Fancy(name = "LevelApp", tags = {"Level", "class enum"})
public enum Level {
    STANDARD,
    PREMEIUM,
    VIP
    // pada enum masih bisa membuat method
}
