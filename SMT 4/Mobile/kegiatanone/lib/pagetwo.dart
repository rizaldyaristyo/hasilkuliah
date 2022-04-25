// ignore_for_file: prefer_const_constructors

import 'package:flutter/material.dart';
import 'package:kegiatantwo/bottomnavbar.dart';

class PageTwo extends StatefulWidget {
  const PageTwo({Key? key}) : super(key: key);
  @override
  State<PageTwo> createState() => _PageTwoState();
}

class _PageTwoState extends State<PageTwo> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: SingleChildScrollView(
          child: Text("LET'S GOOOO!!!!"),
        ),
        bottomNavigationBar: BottomNavBar(),
      ),
    );
  }
}
