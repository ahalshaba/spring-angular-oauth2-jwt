import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {

  constructor(private http: HttpClient){

  }
  helloAdmin!: any;
  ngOnInit(): void {
    this.http.get("http://localhost:8181/api/hello_admin")
    .subscribe({
      next: data=>{
        
        this.helloAdmin = data;
        
        
      },
      error: err => {
        
        console.log(err);
      }
    });
  }
}
