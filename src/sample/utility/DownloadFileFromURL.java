package sample.utility;

import javafx.concurrent.Task;
import sample.controller.BookDetailsController;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
                    ReadableByteChannel rbc = Channels.newChannel(website.openStream());
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
