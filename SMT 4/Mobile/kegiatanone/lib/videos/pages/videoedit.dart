import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:kegiatantwo/videos/services/videoservice.dart';
import 'package:kegiatantwo/preferences.dart';

class VideoEditPage extends StatefulWidget {
  const VideoEditPage({Key? key}) : super(key: key);

  @override
  State<VideoEditPage> createState() => _VideoEditPageState();
}

class _VideoEditPageState extends State<VideoEditPage> {
  final TextEditingController TFController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: abuabu900,
      appBar: AppBar(
        title: Text('Video Edit'),
        backgroundColor: abuabu700,
      ),
      body: Padding(
        padding: EdgeInsets.all(16),
        child: Consumer<VideoService>(
          builder: (context , video, _) => Column(
            children:[
              Text(video.listVideo[video.selectedIndex!]['title'], style: TextStyle(color: putih)),
              const SizedBox(
                height: 20,
              ),
              Text('Input New Title', style: TextStyle(color: putih)),
              TextFormField(
                controller: TFController, style: TextStyle(color: putih)
              ),
              TextButton(onPressed: (){
                video.updateVideo(video.selectedIndex!, TFController.text);
                Navigator.pop(context);
              }, child: Text('Save', style: TextStyle(color: putih)), )
            ],
          )
        )
      )
    );
  }
}
