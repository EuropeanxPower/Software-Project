package app;

public class Model{

    public void Login(String userID){
        this.currentUserID = userID;
        if (userIDs.contains(userID)){
            loggedIn = true;
            System.out.println("Logged in");
        }
        else {
            errorMessage = "User ID doesn't exist";
            new Errorhandler("User ID doesn't exist");
            System.out.println("User ID doesn't exist");
        }
    }

    public void CreateProject(String name){
        if (projectNames.contains(name)){
            errorMessage = "A project with this name already exists";
            new Errorhandler("A project with this name already exists");
            System.out.println("A project with this name already exists");
        }
        else{
            projectNames.add(name);
            System.out.println("A project with name " +name+ " has been created");
        }
        
    }
    
}