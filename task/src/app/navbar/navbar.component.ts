import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Task } from '../task-model/task-Model';
import { TaskModelService } from '../task-model/task-model.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  taskForm: FormGroup;
  submitted = false;
  taskModel:Task;

  constructor(private formbuilder: FormBuilder, private taskService: TaskModelService,
    private router: Router) {

  }

  ngOnInit() {
    this.taskForm = this.formbuilder.group({
      taskName: [''],
      taskDescription: [''],
      priority: ['']
    });
  }
  

  save(taskModel) {
    this.taskService.createTask(taskModel);
  }


  signup() {
    this.submitted = true;
    var taskModel=new Task(this.taskForm.value.taskName, 
      this.taskForm.value.taskDescription,
      this.taskForm.value.priority,
      "New", Date.now(), null);
      // console.log("aaa");
      // console.log("time",this.taskModel.creationDate);
      this.save(taskModel);  


    // alert('form fields are validated successfully!');
  }

}
