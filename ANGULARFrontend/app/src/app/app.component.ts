import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';

  users : any;
  constructor(private http: HttpClient){
  }

  ngOnInit(): void {
    let resp = this.http.get("https://jsonplaceholder.typicode.com/users");
    resp.subscribe((data)=>this.users=data);
  }

}
