// src/app/components/client-details/client-details.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientService, ClientDTO } from '../../services/client.service';

@Component({
  selector: 'app-client-details',
  templateUrl: './client-details.component.html',
  styleUrls: ['./client-details.component.css'],
  standalone: true
})
export class ClientDetailsComponent implements OnInit {
  client: ClientDTO | undefined;

  constructor(
    private clientService: ClientService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const clientId = Number(this.route.snapshot.paramMap.get('id'));
    this.clientService.getClientById(clientId).subscribe((data) => {
      this.client = data;
    });
  }
}
