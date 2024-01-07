import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { IndexComponent } from './index/index.component';

const routes: Routes = [
    {path: "user", component: UserComponent},
    {path: "admin", component: AdminComponent},
    {path: "index", component: IndexComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
