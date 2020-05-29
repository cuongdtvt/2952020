import { TestBed } from '@angular/core/testing';

import { ExportsService } from './exports.service';

describe('ExportService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ExportsService = TestBed.get(ExportsService);
    expect(service).toBeTruthy();
  });
});
