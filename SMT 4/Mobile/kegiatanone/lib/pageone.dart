// ignore_for_file: prefer_const_constructors
import 'package:flutter/material.dart';
import 'package:kegiatantwo/accountpage.dart';
import 'package:kegiatantwo/preferences.dart';
import 'package:kegiatantwo/bottomnavbar.dart';

class PageOne extends StatefulWidget {
  const PageOne({Key? key}) : super(key: key);
  @override
  State<PageOne> createState() => _PageOneState();
}

class _PageOneState extends State<PageOne> {
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
          body: SingleChildScrollView(
            child: Column(children: [
              Padding(padding: EdgeInsets.only(right: 10, left: 10, top: 10)),
              Container(
                margin: EdgeInsets.only(left: 15),
                child: Align(
                  alignment: Alignment.centerLeft,
                  child: Text(
                    'Good Afternoon ' + usernamenya! + ' !',
                    style: TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.bold,
                        color: putih),
                  ),
                ),
              ),
              for (int i = 1; i <= 5; i++)
                Column(children: [
                  Container(
                    margin: EdgeInsets.only(top: 10),
                    width: double.infinity,
                    height: 180,
                    color: abuabu,
                    child: Image.network(
                        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPYztjfKWOhRiNJqGfRse9DDwe_1tCeqo-HYHtsSl9qFZ6smHaXd05URuB6vTfHNP0BhY&usqp=CAU',
                        fit: BoxFit.cover),
                  ),
                  Row(children: [
                    Container(
                      margin: EdgeInsets.all(8.0),
                      child: ClipRRect(
                        borderRadius: BorderRadius.circular(30.0),
                        child: Image.network(
                            'https://cutewallpaper.org/22/halloween-profile-pictures-wallpapers/1333125595.jpg',
                            height: 35.0,
                            width: 35.0),
                      ),
                    ),
                    Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text('Video ' + i.toString(),
                              style: TextStyle(
                                  fontWeight: FontWeight.bold,
                                  fontSize: 13,
                                  color: putih)),
                          Text(
                              'Channel ' +
                                  i.toString() +
                                  '  •  100K Views  20K Likes',
                              style: TextStyle(
                                  fontWeight: FontWeight.w300,
                                  fontSize: 12,
                                  color: putih))
                        ])
                  ]),
                ]),
            ]),
          ),
          bottomNavigationBar: BottomNavBar(),
        ),
      ),
    );
  }
}
