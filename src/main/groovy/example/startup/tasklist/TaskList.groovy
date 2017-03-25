package example.startup.tasklist

import groovy.transform.CompileStatic

/**
 *
 */
@CompileStatic
class TaskList {
  List<Task> loaded = []
  List<Task> search(String word) {
    loaded.findAll {it.title.contains(word)}
  }
  static TaskList load(List<String> tasks){
    new TaskList(loaded: tasks.collect{new Task(title: it)})
  }
}
@CompileStatic
class Task{
  String title
}
