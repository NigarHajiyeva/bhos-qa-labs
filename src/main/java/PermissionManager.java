public class PermissionManager {
    private PermissionLevel mCurrentLevel = PermissionLevel.USER;

    public String getPermissionLevel() {
        String position;

        switch(mCurrentLevel) {
            case ADMIN:
                position = "ADMIN";
                break;
            case DEVELOPER:
                position = "DEVELOPER";
                break;
            case USER:
                position = "USER";
                break;
            default:
                throw new IllegalStateException("Unexpected: " + mCurrentLevel);
        }
        return position;
    }

    public void setPermissionLevel(PermissionLevel permissionLevel) {
        mCurrentLevel = permissionLevel;
    }
}
