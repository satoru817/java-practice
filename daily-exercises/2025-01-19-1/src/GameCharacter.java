public abstract class GameCharacter<T extends Stats> {
    protected String name;
    protected T stats;
    protected int level;

    // キャラクターの基本行動を定義
    public abstract void attack(GameCharacter<?> target);
    public abstract void levelUp();

    // 実装してください
}