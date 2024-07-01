import java.io.Serializable;
/**
 * The {@code User} class represents a user in the system.
 * It implements the {@code Serializable} interface to allow for object serialization.
 */
public class User implements Serializable{
    private String username;
    private String password;
    private String userID;
    private Branch branch;
    private String role;
    private boolean passwordchanged;
    private String gender;
    private int age;

    /**
     * Constructs a new {@code User} object with the specified parameters.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @param branch   The branch associated with the user.
     * @param role     The role of the user.
     * @param gender   The gender of the user.
     * @param age      The age of the user.
     * @param userID   The unique identifier of the user.
     */
    public User(String username, String password, Branch branch, String role, String gender, int age, String userID){
        this.username = username;
        this.password = password;
        this.branch = branch;
        this.role = role;
        this.passwordchanged = false;
        this.gender = gender;
        this.age = age;
        this.userID = userID;

    }

    public String getUserID(){
        return this.userID;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public Branch getBranch(){
        return this.branch;
    }
    public String getRole(){
        return role;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setBranch(Branch branch){
        this.branch = branch;
    }
    public void setRole(String role){
        this.role = role;
    }
    public boolean checkchanged(){
        return passwordchanged;
    }
    /**
     * Sets the flag indicating whether the user's password has been changed.
     *
     * @param checker The new value of the flag.
     */
    public void setPasswordChanged(boolean checker){
        passwordchanged = checker;
    }
}