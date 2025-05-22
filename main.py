"""GoogleDocDecoder: A simple script to decode Google Docs content and print it in the terminal."""
# -*- coding: utf-8 -*-

from io import StringIO
import requests
import pandas as pd
            
class GoogleDocDecoder:
    """A class to decode Google Docs content and print it in the terminal."""

    def print_char(self, x, y, char):
        """Prints a character at the specified (x, y) coordinates in the terminal."""
        print(f"\033[{y};{x}H{char}", end="")  # Moves cursor and prints character

    def clear_terminal(self):
        """Clears the terminal screen and moves the cursor to the top-left."""
        print("\033[2J\033[H", end="")  # Clear screen and reset cursor position

    def decode_from_url(self, url):
        """Fetches the content from the given URL and decodes it."""
        response = requests.get(url, timeout=100)

        df_list = pd.read_html((StringIO(response.text)))

        for df in df_list:
            for index, row in df.iterrows():
                if index == 0:
                    continue
                self.print_char(row[0], row[2], row[1])

def main():
    """Main function to run the GoogleDocDecoder."""
    url = "https://docs.google.com/document/d/e/2PACX-1vQGUck9HIFCyezsrBSnmENk5ieJuYwpt7YHYEzeNJkIb9OSDdx-ov2nRNReKQyey-cwJOoEKUhLmN9z/pub"
    decoder = GoogleDocDecoder()
    decoder.clear_terminal()
    decoder.decode_from_url(url)

if __name__ == "__main__":
    main()
