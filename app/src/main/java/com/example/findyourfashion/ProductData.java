package com.example.findyourfashion;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
    public static List<Product> getAllProducts() {
        List<Product> all = new ArrayList<>();
        all.addAll(getProductsByCategory("Men"));
        all.addAll(getProductsByCategory("Women"));
        all.addAll(getProductsByCategory("Accessories"));
        all.addAll(getProductsByCategory("Shoes"));
        return all;
    }

    public static ArrayList<Product> getProductsByCategory(String category) {
        ArrayList<Product> products = new ArrayList<>();

        switch (category) {

            case "Men":
                products.add(new Product(
                        "Navy Knit Polo Shirt",
                        R.drawable.men1,
                        "$42",
                        "This navy knit polo shirt brings together smart texture and relaxed style. With a tailored fit and breathable fabric, it's ideal for summer evenings or polished daywear."
                ));

                products.add(new Product(
                        "Beige Knit Polo Shirt",
                        R.drawable.men2,
                        "$42",
                        "A modern essential — this beige short-sleeve knit polo shirt features a breathable design with intricate weave detail. Perfect for pairing with white or neutral trousers for a fresh look."
                ));

                products.add(new Product(
                        "Utility Cargo Pants",
                        R.drawable.men3,
                        "$55",
                        "Relaxed-fit brown cargos with oversized pockets. Durable, stylish, and made for movement."
                ));
                products.add(new Product(
                        "Mandarin Collar Shirt",
                        R.drawable.men4,
                        "$48",
                        "Elegant cream shirt with a mandarin collar and button loops — perfect for formal occasions."
                ));
                products.add(new Product(
                        "Tropical Print Shirt",
                        R.drawable.men5,
                        "$39",
                        "Beach-ready shirt in floral blue print. Lightweight and breathable for sunny adventures."
                ));
                products.add(new Product(
                        "Boxy Sage Jacket",
                        R.drawable.men6,
                        "$64",
                        "Minimalist cropped jacket in sage green. Crisp lines and subtle structure make it ultra-modern."
                ));
                products.add(new Product(
                        "Washed Blue Jeans",
                        R.drawable.men7,
                        "$49",
                        "Wide-leg denim in a classic faded wash. Soft, relaxed, and timeless."
                ));
                products.add(new Product(
                        "Sand Cargo Trousers",
                        R.drawable.men8,
                        "$52",
                        "Neutral cargo trousers with reinforced seams and streetwear vibes. Great utility piece."
                ));
                products.add(new Product(
                        "Layered Crewneck Tee",
                        R.drawable.men9,
                        "$35",
                        "Double-layered knit tee in oatmeal and cream tones. Comfy yet polished."
                ));
                break;

            case "Women":
                products.add(new Product("Floral Puff Midi Dress", R.drawable.women1, "$58",
                        "A dreamy puff-sleeve midi dress with delicate floral prints and a shirred bodice—perfect for romantic strolls or garden parties."));

                products.add(new Product("Elegant Office Chic Set", R.drawable.women2, "$74",
                        "A bold and confident ensemble featuring a crimson blouse and navy high-waist trousers for a sleek office look."));

                products.add(new Product("Rust Linen V-Neck Dress", R.drawable.women3, "$52",
                        "Effortlessly stylish and breathable, this linen V-neck dress in earthy rust tones makes a beautiful boho statement."));

                products.add(new Product("Buttoned Linen Day Dress", R.drawable.women4, "$63",
                        "Light and breezy with button-down details, this puff-sleeve linen dress brings both comfort and charm."));

                products.add(new Product("Floral Lounge Kurta Set", R.drawable.women5, "$47",
                        "A relaxed kurta and pant combo with cheerful florals in teal, pink, and yellow—a vibrant pick for daily comfort."));

                products.add(new Product("Embroidered Palazzo Ensemble", R.drawable.women6, "$69",
                        "Elevate your elegance with this dramatic wide-leg palazzo and cropped blouse combo adorned with embroidery."));

                products.add(new Product("Turtleneck Wine Power Look", R.drawable.women7, "$85",
                        "Bold and empowering—wine turtleneck top paired with tailored grey pants for a classy professional vibe."));

                products.add(new Product("Ocean Breeze Cutout Dress", R.drawable.women8, "$68",
                        "Capture beachside vibes with this flowing halter maxi dress featuring a tropical print and stylish cutouts."));

                products.add(new Product("Vintage Beige Suit Shirt", R.drawable.women9, "$59",
                        "Minimalist elegance meets vintage flair in this structured collared shirt and pleated high-rise trousers."));

                products.add(new Product("Cream Tucked Tee & Trousers", R.drawable.women10, "$49",
                        "An everyday neutral-toned outfit styled with precision: structured tee tucked into pleated beige trousers."));
                break;

            case "Shoes":
                products.add(new Product("Beige Casual Sneakers", R.drawable.shoes1, "$49",
                        "Effortless beige sneakers with a sleek low-top design. Lightweight and durable for everyday wear."));
                products.add(new Product("Classic Leather Derbies", R.drawable.shoes2, "$89",
                        "Sophisticated oxblood leather derbies with a timeless shape. Perfect for formal or smart casual outfits."));
                products.add(new Product("Retro Street Sneakers", R.drawable.shoes3, "$64",
                        "Sporty retro low-tops with caramel and white contrast. Designed for urban edge and all-day comfort."));
                products.add(new Product("Bold Orange Suede Loafers", R.drawable.shoes4, "$72",
                        "Statement orange suede loafers with tassel detailing. Adds a playful luxury to casual or festive fits."));
                products.add(new Product("Tan Penny Loafers", R.drawable.shoes5, "$79",
                        "Handcrafted tan leather loafers with polished finish. A refined staple for work or weekend wear."));
                products.add(new Product("Chelsea Ankle Boots", R.drawable.shoes6, "$88",
                        "Classic brown Chelsea boots with elastic sides and a sleek leather look. A rugged yet versatile option."));
                products.add(new Product("Monochrome Street Runners", R.drawable.shoes7, "$59",
                        "Bold and structured tan sneakers made for the street. Comfortable outsole for all-day performance."));
                products.add(new Product("Black Leather Chelsea Boots", R.drawable.shoes8, "$99",
                        "Modern minimalist black Chelsea boots with premium matte finish. Urban fashion meets timeless design."));
                break;

            case "Accessories":
                products.add(new Product(
                        "Cherry Tint Sunglasses",
                        R.drawable.accessories1,
                        "$37",
                        "Retro rectangle-frame sunglasses with a deep cherry tint. Sleek, minimal, and built for sunny days."
                ));
                products.add(new Product(
                        "Mini Bow Pendant Necklace",
                        R.drawable.accessories2,
                        "$26",
                        "Delicate gold chain with an elegant bow pendant. A dainty and timeless piece for everyday charm."
                ));
                products.add(new Product(
                        "Starry Charm Bracelet",
                        R.drawable.accessories3,
                        "$24",
                        "Dainty bracelet featuring colorful enamel star charms on a gold-tone chain. Perfect for everyday sparkle."
                ));
                products.add(new Product(
                        "Tortoise Oval Sunglasses",
                        R.drawable.accessories4,
                        "$39",
                        "Retro oval sunglasses in tortoise frame with dark green lenses — fashion-forward and UV protected."
                ));
                products.add(new Product(
                        "Golden Loop Earrings",
                        R.drawable.accessories5,
                        "$32",
                        "Modern textured gold earrings with a circular twist design. Lightweight, elegant, and perfect for events."
                ));
                products.add(new Product(
                        "Layered Crystal Bracelet",
                        R.drawable.accessories6,
                        "$44",
                        "Triple-layer gold bracelet adorned with bezel-set crystals. Elegant layering made simple."
                ));
                products.add(new Product(
                        "Leaf Wrap Ring",
                        R.drawable.accessories7,
                        "$27",
                        "Nature-inspired open ring in gold with intricate leaf detailing. Adjustable and bold."
                ));
                products.add(new Product(
                        "Mountain Engraved Ring",
                        R.drawable.accessories8,
                        "$29",
                        "Oxidized silver-tone band with engraved landscape featuring mountains, trees, and sun. Rustic and meaningful."
                ));
                products.add(new Product(
                        "Vintage Denim Cap",
                        R.drawable.accessories9,
                        "$35",
                        "Washed denim cap with vintage stitching and relaxed fit. A timeless accessory with casual vibes."
                ));
                break;

            default:
                products.add(new Product("Featured Item", R.drawable.men, "$0.00",
                        "Explore our top picks and new arrivals from all categories in one place."));
                break;
        }

        return products;
    }
}
