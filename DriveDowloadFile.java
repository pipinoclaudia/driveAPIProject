


import java.io.IOException;

import com.google.api.client.http.javanet.NetHttpTransport;

import com.google.api.services.drive.model.File;

public class DriveDowloadFile {

	private static NetHttpTransport HTTP_TRANSPORT;

		private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), "Desktop/drive_sample");
	//	private static final java.io.File DIR_FOR_DOWNLOADS = new java.io.File(System.getProperty("user.home"), "Desktop/drive_sample");
	public DriveDowloadFile(NetHttpTransport HTTP_TRANSPORT) {
		// TODO Auto-generated constructor stub
		this.HTTP_TRANSPORT = HTTP_TRANSPORT;
	}


	/**
	 * Invece di farmi settordicimila pipponi mentali(la cui documentazione e' disponibile sotto questa pagina),
	 * restituisco l'url per la query da browser. Così mi ha insegnato il buon Costagliola.
	 * Nel comune ambiente informatico questa saggia mossa viene chiamata coloured patch: PEZZA A COLORI. 
	 * Ovviamente bisogna ricordarsi di passare questa url creata nella jsp e fare un href per aprire una nuova 
	 * pagina dal web browser. Fa schifo, ma è comunque una mia creazione; ogni scarrafon e' bella à mamma soja.
	 * 
	 * Di necessità virtù. 
	 * 
	 * 
	 * Cordiali saluti
	 * Claudia Pipino*/
	
	
	public String downloadGoogleFile(File idGoogleFile){

		
		return "https://drive.google.com/file/d/"+idGoogleFile.getId()+"/view";
	
	}

}



























//Drive driveService = DriveMain.getDriveService(HTTP_TRANSPORT);
//
//driveService.files().get(idGoogleFile).buildHttpRequestUrl();
//String title = idGoogleFile.getName();
//String webContentLink = idGoogleFile.getWebContentLink();
//System.out.println(webContentLink);
//InputStream in = new URL(webContentLink).openStream();
//
//InputStreamReader i = new InputStreamReader(in);
//
//BufferedReader br = new BufferedReader(i);
//
//BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_STORE_DIR+"/"+title));	
//
//String read = "";
//
//while((read = br.readLine())!= null){
//	bw.write(read+"\n");
//	
//}
//
//bw.close();
//br.close();


//Drive driveService = DriveMain.getDriveService(HTTP_TRANSPORT);
//GenericUrl path = driveService.files().get(idGoogleFile.getId()).buildHttpRequestUrl();
//String title = idGoogleFile.getName();
//
//java.io.File tostore = new java.io.File(DATA_STORE_DIR+"/"+title);
//URI uri = null;
//try {
//	uri = new URI(path+"");
//} catch (URISyntaxException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//URL url = uri.toURL();
//
//
//System.out.println("mi connetto a "+ url.toString());
//
//HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//conn.setRequestMethod("GET");
//conn.setDoOutput(false);
//conn.connect();
//
//BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
//
//
//BufferedWriter bw = new BufferedWriter(new FileWriter(tostore));		
//
//String read = "";
//
//while((read = in.readLine())!= null){
//	bw.write(read+"\n");
//}
//bw.close();
//in.close();
//

//String webContentLink = idGoogleFile.getWebContentLink().;
//System.out.println(webContentLink);
//OutputStream outputStream = new ByteArrayOutputStream();
//driveService.files().get(idGoogleFile).executeAndDownloadTo(outputStream);



