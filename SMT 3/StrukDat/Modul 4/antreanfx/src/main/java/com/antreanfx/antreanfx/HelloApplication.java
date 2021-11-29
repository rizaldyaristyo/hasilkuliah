package com.antreanfx.antreanfx;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class Link{
    String dData;
    Link next;
    public Link(String d){
        dData=d;
    }
    public String displayLinkReturn(){
        return dData;
    }
}

class FirstLastList{
    Link first;
    Link last;

    public FirstLastList(){
        first=null;
        last=null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    public void insertLast(String dd){
        Link newLink = new Link(dd);
        if(isEmpty())first=newLink;
        else last.next=newLink;
        last=newLink;
    }

    public void deleteFirst(){
        if (first.next==null) last=null;
        first=first.next;
    }


    public String displayHead(){
        Link current=first;
        if(current!=null) return current.displayLinkReturn();
        else return "Kosong!";
    }

    public String displayLast(){
        Link current=last;
        if(current!=null) return current.displayLinkReturn();
        else return "Kosong!";
    }

    public int queueSize(){
        Link current = first;
        int sizeNya=0;
        while (current!=null) {
            sizeNya++;
            current=current.next;
        }
        return sizeNya;
    }
}

class LinkQueue{ //enqueue[ok] dequeue[ok] peek[ok] isEmpty[ok] size[ok]
    FirstLastList theList;
    public LinkQueue(){
        theList=new FirstLastList();
    }
    public boolean isEmpty(){
        return theList.isEmpty();
    }
    public void enqueue(String j){
        theList.insertLast(j);
    }
    public void dequeue(){
        theList.deleteFirst();
    }
    public String peek(){
        return theList.displayHead();
    }
    public String peekNext(){
        return theList.displayLast();
    }
    public int size(){
        return theList.queueSize();
    }
}

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        LinkQueue queue = new LinkQueue();
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10); gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));
        Scene sc = new Scene(gp,480,280);
        stage.setScene(sc);
        stage.setTitle("!!-=AntreFX=-!!");

        Text title = new Text("AntreanFX");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        Button tambah = new Button("Tambahkan Nama Ke Antrean");
        Button next = new Button("Antrean Selanjutnya");

        Text antreanSekarang=new Text("Antrean Sekarang");
        String isEmpty;
        if (queue.isEmpty()) isEmpty = "Kosong";
        else isEmpty = queue.peek();

        Text outEntry=new Text(isEmpty);
        outEntry.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));

        Text antreanTerbaru=new Text("Antrean Terbaru");
        Text latestEntry=new Text(isEmpty);
        latestEntry.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));

        Text nama = new Text("Nama: ");
        TextField tf = new TextField();
        HBox hBox = new HBox();
        ObservableList hboxList = hBox.getChildren();
        hboxList.addAll(nama,tf);

        Text panjangAntrean = new Text("Panjang Antrean: ");
        Text queueSize = new Text(String.valueOf(queue.size()));
        HBox hBox2 = new HBox();
        ObservableList hboxList2 = hBox2.getChildren();
        hboxList2.addAll(panjangAntrean,queueSize);

        gp.add(title,0,0);
        gp.add(hBox,1,0);
        gp.add(tambah,1,1);
        gp.add(next,0,1);
        gp.add(antreanSekarang,1,2);
        gp.add(outEntry,1,3);
        gp.add(antreanTerbaru,0,2);
        gp.add(latestEntry,0,3);
        gp.add(hBox2,0,4);

        tambah.setOnAction(plus->{
            queue.enqueue(tf.getText());
            System.out.println("masuk: "+tf.getText());
            tf.clear();
            outEntry.setText(queue.peek());
            latestEntry.setText(queue.peekNext());
            queueSize.setText(String.valueOf(queue.size()));
            stage.setScene(sc);
            stage.show();
        });
        next.setOnAction(minus->{
            System.out.println("peek: "+queue.peek());
            queue.dequeue();
            outEntry.setText(queue.peek());
            latestEntry.setText(queue.peekNext());
            queueSize.setText(String.valueOf(queue.size()));
            stage.setScene(sc);
            stage.show();
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}