import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';



import { Task } from './task-model';

@Injectable({
    providedIn: 'root'
})
export class TaskModelService {
    taskalllist= [];
    taskList: Task[] = [];

    constructor() { }

    getAllTasks() {
        return this.taskalllist;
    }

    //Create Task
    createTask(task: Task) {
        console.log(task);
        this.taskalllist.push(task);
    }

    //Update task
    updateTask(task: Task) {
        
    }
    //Delete task	
    deleteTask(task: Task) {
        
    }
    
}