import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:kegiatantwo/videos/services/videoservice.dart';
import 'package:kegiatantwo/preferences.dart';

class VideoAddPage extends StatefulWidget {
  const VideoAddPage({Key? key}) : super(key: key);

  @override
  State<VideoAddPage> createState() => _VideoAddPageState();
}

class _VideoAddPageState extends State<VideoAddPage> {
  final TextEditingController TFController1 = TextEditingController();
  final TextEditingController TFController2 = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: abuabu900,
      appBar: AppBar(
        title: Text('Add Video'),
        backgroundColor: abuabu700,
      ),
      body: Padding(
        padding: EdgeInsets.all(16),
        child: Consumer<VideoService>(
          builder: (context , video, _) => Column(
            children:[
              Text('Input URL', style: TextStyle(color: putih)),
              TextFormField(
                controller: TFController1
              , style: TextStyle(color: putih)
              ),
              Text('Input Title', style: TextStyle(color: putih)),
              TextFormField(
                controller: TFController2,
              ),
              TextButton(onPressed: (){
                video.addVideo(TFController1.text, TFController2.text);
                Navigator.pop(context);
              }, child: Text('Save', style: TextStyle(color: putih)), )
            ],
          )
        )
      )
    );
  }
}
