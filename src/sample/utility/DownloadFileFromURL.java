package sample.utility;

import javafx.concurrent.Task;
import sample.controller.BookDetailsController;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadFileFromURL{
    BookDetailsController bookDetailsController;
    String filePath,  fileName,  url;

    public void setData(String _filePath, String _fileName, String _url){
        filePath=_filePath;
        fileName=_fileName;
        url=_url;
    }

    public void download(){
        Task<Integer> task = new Task<Integer>() {
            @Override
            public Integer call() {
                try{
                    System.out.println("init download");

                    new File(filePath).mkdirs();
                    URL website = new URL(url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)website.openConnection();
                    httpURLConnection.addRequestProperty("User-Agent", "Mozilla / 5.0 (Windows NT 6.1; WOW64) AppleWebKit / 537.36 (KHTML, like Gecko) Chrome / 40.0.2214.91 Safari / 537.36");
                    ReadableByteChannel rbc = Channels.newChannel(httpURLConnection.getInputStream());
                    FileOutputStream fos = new FileOutputStream(filePath + "/" + fileName);
                    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

                    System.out.println("finish download");

                }catch (Exception e){
                    e.printStackTrace();
                }

                System.out.println("thread finished");

                return 0 ;
            }
        };

        task.setOnSucceeded(e -> {
            // update UI with result
            bookDetailsController.onFinishDownload();
        });

        new Thread(task).start();
    }



    /**
     * Before starting background thread
     * */


    public void setBookDetailsController(BookDetailsController bookDetailsController) {
        this.bookDetailsController = bookDetailsController;
    }
}
