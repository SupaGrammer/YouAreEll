/**
 * @TODO
 * I am POJO-JOJO!
 */

public class User {
    //fields
    private String userId;
    private String name;
    private String githubHandle;
    //Constructor
    public User(String userId, String name, String githubHandle) {
        this.userId = userId;
        this.name = name;
        this.githubHandle = githubHandle;
    }

    @Override //custom toString method that appends the userID after username to a string with the associated github ID
    public String toString() {
        return this.name + " - " + this.userId + " - " + this.githubHandle;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGithubHandle() {
        return githubHandle;
    }

    public void setGithubHandle(String githubHandle) {
        this.githubHandle = githubHandle;
    }
}