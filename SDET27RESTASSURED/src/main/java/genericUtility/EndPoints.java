package genericUtility;
/**
 * This interface contains all the endpoints
 * @author ASHUTOSH NAYAK
 *
 */

public interface EndPoints {
	String Createproject="/addProject";
	String Allprojects="/projects";
	String Singleproject="/projects/{projectId}"; 
	String Updateproject="/projects/TY_PROJ_2402";
	String Deleteproject="/projects/{projectId}";

}
