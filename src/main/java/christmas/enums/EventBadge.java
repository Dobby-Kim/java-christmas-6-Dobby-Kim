package christmas.enums;

public enum EventBadge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("스타", 5_000),
    NONE("없음", 0);

    private final String badgeName;
    private final int badgeStandard;

    EventBadge(String badgeName, int badgeStandard) {
        this.badgeName = badgeName;
        this.badgeStandard = badgeStandard;
    }

    public int getBadgeStandard() {
        return badgeStandard;
    }

    public String getBadgeName() {
        return badgeName;
    }
}
