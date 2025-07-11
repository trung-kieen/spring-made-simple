import { TestBed } from '@angular/core/testing';

import { MyHttpClient } from './my-http-client';

describe('MyHttpClient', () => {
  let service: MyHttpClient;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyHttpClient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
