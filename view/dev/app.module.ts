import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";
import {HttpClient} from "./common/services/http-client.service";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {AppComponent} from "./app.component";
import {FormsModule} from '@angular/forms';
import {HomeService} from './home/home.service';
import {DetailsComponent} from './details/details.component';
import {DetailsService} from './details/details.service';
import {CreationComponent} from './creation/creation.component';

const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'details/:id', component: DetailsComponent },
  { path: 'new', component:  CreationComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(
      appRoutes
    ),
    FormsModule 
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    DetailsComponent,
    CreationComponent
  ],
  providers: [HttpClient, HomeService, DetailsService],
  bootstrap: [AppComponent]

})
export class AppModule {
}
