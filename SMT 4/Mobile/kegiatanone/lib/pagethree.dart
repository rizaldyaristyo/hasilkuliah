// ignore_for_file: prefer_const_constructors

import 'package:flutter/material.dart';
import 'package:kegiatantwo/accountpage.dart';
import 'package:kegiatantwo/bottomnavbar.dart';
import 'preferences.dart';

class PageThree extends StatefulWidget {
  const PageThree({Key? key}) : super(key: key);

  @override
  State<PageThree> createState() => _PageThreeState();
}

class _PageThreeState extends State<PageThree> {
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
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                GestureDetector(
                  onTap: () {},
                  child: Column(
                    children: [
                      Icon(Icons.play_disabled, color: putih),
                      Text(
                        'Currently, There\'s no Live on Air...',
                        style: TextStyle(color: putih),
                      ),
                    ],
                  ),
                )
              ],
            ),
          ),
          bottomNavigationBar: BottomNavBar(),
        ),
      ),
    );
  }
}
