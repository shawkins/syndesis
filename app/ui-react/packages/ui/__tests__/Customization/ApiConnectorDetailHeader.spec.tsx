import { render } from '@testing-library/react';
import * as React from 'react';
import { ApiConnectorDetailCard } from '../../src/Customization/apiClientConnectors';
import icons from '../icons';

it('Renders the expected connector name and description', () => {
  const expectedIcon = icons.beer;
  const expectedName = 'Test';
  const expectedDescription = 'This is a description.';

  const { getByText } = render(
    <ApiConnectorDetailCard
      description={expectedDescription}
      icon={expectedIcon}
      name={expectedName}
    />
  );

  // Expect the connector name to be visible
  expect(getByText(expectedName)).toBeInTheDocument();

  // Expect the connector description to be visible
  expect(getByText(expectedDescription)).toBeInTheDocument();

  // Expect the connector icon to be visible
  expect(getByText(expectedIcon)).toBeInTheDocument();
});
