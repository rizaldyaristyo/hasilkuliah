import 'package:flutter/material.dart';
import 'package:kegiatantwo/videos/pages/videoadd.dart';
import 'videoedit.dart';
import 'package:kegiatantwo/videos/services/videoservice.dart';
import 'package:provider/provider.dart';

class VideoListPage extends StatelessWidget {
  const VideoListPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Video List'),
      ),
      body: Padding(
      padding: const EdgeInsets.only(left: 10, right: 10),
      child: Column(
        children: [
          Expanded(
              child: Consumer<VideoService>(
                builder: (context, video, _) => ListView.builder(
                  itemCount: video.listVideo.length,
                  itemBuilder: (context, index){
                    return GestureDetector(
                      onTap: () {
                        video.selectedIndex = index;
                        Navigator.push(
                          context, MaterialPageRoute(
                            builder: (context) => const VideoEditPage()),
                        );
                      },
                      onLongPress: (){
                        video.deleteVideo(index);
                      },
                      child: Container(
                        color: Colors.white54,
                        padding: const EdgeInsets.symmetric(vertical: 20),
                        margin: const EdgeInsets.symmetric(vertical: 10),
                        child: Row(
                          children: [
                            Expanded(
                                child: Padding(
                                  padding: const EdgeInsets.only(left: 5),
                                  child: Text(video.listVideo[index]['url'],
                                  style: TextStyle(
                                    fontSize: 22,
                                    fontWeight: FontWeight.bold
                                  ),
                                  ),
                                ),
                            ),
                            Padding(
                              padding: const EdgeInsets.only(right: 5),
                              child: Text(video.listVideo[index]['title'].toString(),
                                style: TextStyle(
                                  fontSize: 25,
                                  fontWeight: FontWeight.bold
                                ),
                              ),
                            ),
                          ],
                        ),
                      ),
                    );
                  },
                ),
              )
          ),
          ElevatedButton(onPressed: (){
            Navigator.push(
              context, MaterialPageRoute(
                builder: (context) => const VideoAddPage()),
            );
          },child: Text('Add Video'),
          ),
          Padding(padding: EdgeInsets.only(bottom: 10)),
        ],
      ),
    ),
    );
  }
}
