import 'package:flutter/material.dart';
import 'package:kegiatantwo/preferences.dart';

class VideoService extends ChangeNotifier {
  int? selectedIndex;
  List<Map<String, dynamic>> listVideo = [
    {
      'url': 'https://picsum.photos/720?random=1',
      'title': 'Video 1',
    },
    {
      'url': 'https://picsum.photos/720?random=2',
      'title': 'Video 2',
    },
    {
      'url': 'https://picsum.photos/720?random=3',
      'title': 'Video 3',
    }
  ];

  void updateVideo(int index, String title) {
    List<Map<String, dynamic>> listTemp = [];
    for (var i = 0; i < listVideo.length; i++) {
      if (i == index) {
        listTemp.add({
          'title': title,
          'url': listVideo[i]['url'],
        });
      } else {
        listTemp.add(listVideo[i]);
      }
    }
    listVideo = listTemp;
    notifyListeners();
  }

  void addVideo(String url, String title) {
    listVideo.add({
      'url': url,
      'title': title,
    });
    notifyListeners();
  }

  void deleteVideo(int index) {
    listVideo.removeAt(index);
    notifyListeners();
  }
}
