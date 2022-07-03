// ignore_for_file: prefer_const_constructors

import 'package:flutter/material.dart';
import 'package:kegiatantwo/accountpage.dart';
import 'package:kegiatantwo/bottomnavbar.dart';
import 'preferences.dart';
import 'package:kegiatantwo/videos/pages/videoadd.dart';
import 'package:kegiatantwo/videos/pages/videoedit.dart';
import 'package:kegiatantwo/videos/services/videoservice.dart';
import 'package:provider/provider.dart';

class PageFive extends StatefulWidget {
  const PageFive({Key? key}) : super(key: key);

  @override
  State<PageFive> createState() => _PageFiveState();
}

class _PageFiveState extends State<PageFive> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: DefaultTabController(
        length: 5,
        child: Scaffold(
          backgroundColor: abuabu900,
          appBar: AppBar(
              backgroundColor: abuabu700,
              title: SizedBox(
                width: 50,
                child: Image.network(
                    'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Logo_of_YouTube_%282015-2017%29.svg/320px-Logo_of_YouTube_%282015-2017%29.svg.png',
                    fit: BoxFit.contain),
              ),
              actions: <Widget>[
                Padding(
                  padding: EdgeInsets.all(10.0),
                  child: GestureDetector(
                    onTap: () {},
                    child: const Icon(Icons.search, size: 26.0),
                  ),
                ),
                Padding(
                  padding: EdgeInsets.all(10.0),
                  child: GestureDetector(
                    onTap: () {},
                    child: const Icon(Icons.edit_notifications, size: 26.0),
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.only(right: 20.0, left: 5.0),
                  child: GestureDetector(
                    onTap: () {
                      Navigator.of(context).push(MaterialPageRoute(
                          builder: (_) => AccountPage(), maintainState: false));
                    },
                    child: const Icon(Icons.account_circle_rounded, size: 26.0),
                  ),
                ),
              ]),
          body: SizedBox.expand(
            child: Padding(
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
                                  child: Image.network(
                                   video.listVideo[index]['url'].toString() ,
                        fit: BoxFit.cover),
                                ),
                            ),
                            Padding(
                              padding: const EdgeInsets.only(right: 5, left: 8),
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
    )
          ),
          bottomNavigationBar: BottomNavBar(),
        ),
      ),
    );
  }
}
