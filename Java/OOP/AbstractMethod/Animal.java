package AbstractMethod;

public abstract class Animal {
    public String name;

    public abstract void run();
    // disaat kita membuat abstract method tidak boleh membuat block method, dan child nya harus membuat method overiding
    // dari method tersebut
}
