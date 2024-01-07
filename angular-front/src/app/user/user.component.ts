import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit{

  constructor(private http: HttpClient){

  }
  helloUser!: any;
  ngOnInit(): void {
    this.http.get("http://localhost:8181/api/hello_user")
    .subscribe({
      next: data=>{
        
        this.helloUser = data;
        
        
      },
      error: err => {
        
        console.log(err);
      }
    });
  }

}
