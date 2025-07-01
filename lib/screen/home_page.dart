import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              FloatingActionButton(heroTag: 'Victor', onPressed: () {},child: Text("Víctor")),
              FloatingActionButton(heroTag: 'Pablo', onPressed: () {}, child: Text("Pablo")),
              FloatingActionButton(heroTag: 'Alex', onPressed: () {}, child: Text("Alex")),
              FloatingActionButton(
                heroTag: 'Karlos',
                onPressed: () {
                  Navigator.pushNamed(context, '/pantallakarlos');
                },
                child: Text("Karlos"),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
