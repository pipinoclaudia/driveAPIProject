package it.seci.motusonlus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
 
public class GetSubFolders {
	
	private static NetHttpTransport HTTP_TRANSPORT;
	public GetSubFolders(NetHttpTransport HTTP_TRANSPORT) {
		// TODO Auto-generated constructor stub
		this.HTTP_TRANSPORT = HTTP_TRANSPORT;
	}
 
    // com.google.api.services.drive.model.File
    private static final List<File> getGoogleSubFolders(String googleFolderIdParent) throws IOException {
 
        Drive driveService = DriveMain.getDriveService(HTTP_TRANSPORT);
 
        String pageToken = null;
        List<File> list = new ArrayList<File>();
 
        
       // String query = "mimeType = 'application/vnd.google-apps.folder' and '"+googleFolderIdParent+"' in parents";
        String query = "'"+googleFolderIdParent+"' in parents";
        do {
            FileList result = driveService.files().list().setQ(query).setFields("nextPageToken, files(id, name, createdTime)").setPageToken(pageToken).execute();
            for (File file : result.getFiles()) {
                list.add(file);
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        //
        return list;
    }
 
    // com.google.api.services.drive.model.File
    
    /**Questo metodo restituisce la lista delle cartelle contenute nella cartella che si vuole esplorare
     * */
    public static final List<File> getGoogleFolders(String googleFolderIdParent) throws IOException {
    	
        return getGoogleSubFolders(googleFolderIdParent);
    }
    
    /**Questo metodo restituisce l'id della cartella che si vuole esplorare
     * */
    
    public String getGoogleRootFolder(String googleFolderName) throws IOException {
    	return getGoogleRootFolderHide(googleFolderName);
    }
    
    private static String getGoogleRootFolderHide(String googleFolderName) throws IOException {
    	
    	Drive driveService = DriveMain.getDriveService(HTTP_TRANSPORT);
		String query = "mimeType = 'application/vnd.google-apps.folder' and name = '"+googleFolderName+"'";
	
		String id= "";
		// Print the names and IDs for up to 10 files.
		FileList result = driveService.files().list().setQ(query).setFields("nextPageToken, files(id, name)").execute();
		List<File> files = result.getFiles();
		if (files == null || files.isEmpty()) {
			System.out.println("No files found.");
		} else {
			
			for (File file : files) {

				id = file.getId();
				


			}
		}
    	
        return id;
    }
 
}